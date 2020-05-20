package com.cheryl.petit;

import android.widget.Button;

public class Model {

    private int image;
    private String title;
    private String content;
    private Button button;

    public Model(int image, String title, String content) {
        this.image = image;
        this.title = title;
        this.content = content;
        this.button = button;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
}
