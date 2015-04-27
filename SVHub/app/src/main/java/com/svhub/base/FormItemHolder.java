package com.svhub.base;

import com.joanzapata.android.iconify.Iconify;

/**
 * Created by Martin on 26.04.2015.
 */
public class FormItemHolder {
    private Iconify.IconValue icon;
    private String text;
    private String hint;

    public FormItemHolder(Iconify.IconValue icon, String text, String hint){
        this.icon = icon;
        this.text = text;
        this.hint = hint;
    }
    public Iconify.IconValue getIcon() {
        return icon;
    }

    public void setIcon(Iconify.IconValue icon) {
        this.icon = icon;
    }
    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
