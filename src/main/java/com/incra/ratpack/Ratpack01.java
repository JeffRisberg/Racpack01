package com.incra.ratpack;

import com.incra.ratpack.models.Campaign;
import com.incra.ratpack.modules.CampaignHandler;
import com.incra.ratpack.modules.CampaignModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.guice.Guice;
import ratpack.handlebars.HandlebarsModule;
import ratpack.handling.Chain;
import ratpack.server.BaseDir;
import ratpack.server.RatpackServer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static ratpack.handlebars.Template.handlebarsTemplate;
import static ratpack.jackson.Jackson.json;

public class Ratpack01 {

    private static final Logger LOGGER = LoggerFactory.getLogger(Ratpack01.class);

    static DateFormat dateF = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.US);

    public static void main(String[] args) throws Exception {
        Map m = new HashMap();
        m.put("firstName", "John");
        m.put("lastName", "Smith");

        Campaign c1 = new Campaign("Spring 2016 promotion", true, dateF.parse("05/15/2016 14:56:33"));
        Campaign c2 = new Campaign("Summer 2016 promotion", false, dateF.parse("07/16/2016 14:06:33"));
        Campaign c3 = new Campaign("Fall 2016 promotion", false, dateF.parse("09/16/2016 14:06:33"));

        List<Campaign> campaigns = Arrays.asList(c1, c2, c3);
        m.put("campaigns", campaigns);

        RatpackServer.start(s -> s
                        .serverConfig(c -> c.baseDir(BaseDir.find()))
                        .registry(Guice.registry(b -> {
                            b.module(CampaignModule.class);
                            b.module(HandlebarsModule.class);
                        }))
                        .handlers(chain -> chain
                                        .path("foo", ctx -> ctx.render("from the foo handler")) // Map to /foo
                                        .path("bar", ctx -> ctx.render("from the bar handler")) // Map to /bar
                                        .prefix("nested", nested -> { // Set up a nested routing block, which is delegated to `nestedHandler`
                                            nested.path(":var1/:var2?", ctx -> { // The path tokens are the :var1 and :var2 path components above
                                                Map<String, String> pathTokens = ctx.getPathTokens();
                                                ctx.render(
                                                        "from the nested handler, " +
                                                                " var1: " + pathTokens.get("var1") +
                                                                ", var2: " + pathTokens.get("var2")
                                                );
                                            });
                                        })
                                        .path("injected", CampaignHandler.class) // Map to a dependency injected handler
                                        .prefix("static", nested -> nested.fileSystem("assets/images", Chain::files)) // Bind the /static app path to the src/ratpack/assets/images dir
                                        .path("handlebars", ctx ->
                                                ctx.render(handlebarsTemplate("template.html", m, "text/html")))
                                        .path("json", ctx -> ctx.render(json(formDataResponse(m))))
                                        .all(ctx -> ctx.render("root handler!"))
                        )
        );

    }

    static Map formDataResponse(Object data) {
        Map m = new HashMap();

        m.put("status", "ok");
        m.put("data", data);
        return m;
    }
}