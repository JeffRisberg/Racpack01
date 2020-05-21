package com.incra.ratpack.services;

import com.incra.ratpack.models.Campaign;
import java.util.List;

/**
 * An example service interface.
 *
 * @author jeff
 * @since 5/14/16
 */
public interface CampaignService {

  List<Campaign> getCampaigns();
}
