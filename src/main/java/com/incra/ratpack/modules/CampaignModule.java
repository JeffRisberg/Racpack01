package com.incra.ratpack.modules;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import com.incra.ratpack.LoggingHandler;
import com.incra.ratpack.services.CampaignService;
import com.incra.ratpack.services.CampaignServiceImpl;
import ratpack.handling.HandlerDecorator;

/**
 * An example Guice module.
 *
 * @author jeff
 * @since 5/14/16
 */
public class CampaignModule extends AbstractModule {

  /**
   * Adds a service impl to the application, and registers a decorator so that all requests are
   * logged. Registered implementations of {@link ratpack.handling.HandlerDecorator} are able to
   * decorate the application handler.
   *
   * @see CampaignHandler
   */
  protected void configure() {
    bind(CampaignService.class).to(CampaignServiceImpl.class);
    bind(CampaignHandler.class);
    Multibinder.newSetBinder(binder(), HandlerDecorator.class).addBinding()
        .toInstance(HandlerDecorator.prepend(new LoggingHandler()));
  }
}
