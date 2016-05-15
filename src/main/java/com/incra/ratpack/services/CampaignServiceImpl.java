package com.incra.ratpack.services;

import com.incra.ratpack.models.Campaign;
import com.incra.ratpack.modules.CampaignHandler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * The service implementation.
 *
 * @see CampaignHandler
 */
public class CampaignServiceImpl implements CampaignService {

    static DateFormat dateF = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.US);

    public List<Campaign> getCampaigns() {
        try {
            Campaign c1 = new Campaign("Spring 2016 promotion", true, dateF.parse("05/15/2016 14:56:33"));
            Campaign c2 = new Campaign("Summer 2016 promotion", false, dateF.parse("07/16/2016 14:06:33"));
            Campaign c3 = new Campaign("Fall 2016 promotion", false, dateF.parse("09/16/2016 14:06:33"));

            return Arrays.asList(c1, c2, c3);
        } catch (ParseException ex) {
            return new ArrayList<Campaign>();
        }
    }
}