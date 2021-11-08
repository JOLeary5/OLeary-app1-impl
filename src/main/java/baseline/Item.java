/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Jonathan O'Leary
 */
package baseline;

import java.time.LocalDate;

public class Item {

    private String itemTitle;
    private LocalDate itemDate;
    private String itemDescription;
    private boolean complete;

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemDate(LocalDate itemDate) {
        this.itemDate = itemDate;
    }

    public LocalDate getItemDate() {
        return itemDate;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public boolean getComplete(){
        return this.complete;
    }

    public Item(LocalDate date, String title, String description, boolean complete){

        this.setItemDate(date);
        this.setItemTitle(title);
        this.setItemDescription(description);
        this.setComplete(complete);
    }

    public String toString(){
        return this.getItemTitle();
    }
}
