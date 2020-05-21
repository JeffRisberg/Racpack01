package com.incra.ratpack.models;

import java.util.Date;

/**
 * @author Jeff Risberg
 * @since 5/14/16
 */
public class Campaign {

  protected String name;
  protected boolean active;
  protected Date startDate;

  public Campaign(String name, boolean active, Date startDate) {
    this.name = name;
    this.active = active;
    this.startDate = startDate;
  }

  public String getName() {
    return name;
  }

  public boolean isActive() {
    return active;
  }

  public Date getStartDate() {
    return startDate;
  }
}
