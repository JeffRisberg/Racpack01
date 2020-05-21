package com.incra.ratpack.modules;

import com.incra.ratpack.models.Campaign;
import com.incra.ratpack.services.CampaignService;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import ratpack.handling.Context;
import ratpack.handling.Handler;

/**
 * A handler implementation that is created via dependency injection.
 *
 * @see CampaignModule
 */
@Singleton
public class CampaignHandler implements Handler {

  private final CampaignService campaignService;

  @Inject
  public CampaignHandler(CampaignService campaignService) {
    this.campaignService = campaignService;
  }

  @Override
  public void handle(Context context) {
    StringBuffer resultBuffer = new StringBuffer();

    List<Campaign> campaigns = campaignService.getCampaigns();

    for (Campaign campaign : campaigns) {
      resultBuffer.append("campaign: " + campaign.getName() + "\n");
    }
    context.render("service value:" + resultBuffer);
  }
}
