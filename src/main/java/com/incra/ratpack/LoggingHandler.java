package com.incra.ratpack;

import com.incra.ratpack.modules.CampaignModule;
import ratpack.handling.Context;
import ratpack.handling.Handler;

/**
 * An example of a handler implicitly set up by a module
 *
 * @author Jeff Risberg
 * @see CampaignModule
 * @since 5/14/16
 */
public class LoggingHandler implements Handler {

    @Override
    public void handle(Context context) {
        System.out.println("Received: " + context.getRequest().getUri());
        context.next();
    }
}