package com.dfirago.dlt.question.video.model;

import com.dfirago.dlt.question.common.model.AbstractQuestion;

/**
 * Created by Dmytro Firago on 13/06/2017.
 */
public class VideoQuestion extends AbstractQuestion {

    private String video;

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
