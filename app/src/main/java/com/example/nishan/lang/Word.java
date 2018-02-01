package com.example.nishan.lang;

/**
 * Created by nishan on 27-01-2018.
 */

public class Word {
    //Two variable to hold the value of kannada and English
    private String englishTranslation;
    private String kannadaTranslation;
    private static int noImage=-1;
    private int imgId=noImage;
    private int audioId;

    //Constructor to set new numbers
    public Word(String englishTranslation, String kannadaTranslation,int audioId) {
        this.englishTranslation = englishTranslation;
        this.kannadaTranslation = kannadaTranslation;
        this.audioId=audioId;
        //   this.imgId=imgId;
    }

    //Constructor to set new numbers with image
    public Word(String englishTranslation, String kannadaTranslation,int imgId,int audioId) {
        this.englishTranslation = englishTranslation;
        this.kannadaTranslation = kannadaTranslation;
        this.imgId=imgId;
        this.audioId=audioId;
    }

    //Method to return English Value
    public String getEnglishTransLation() {
        return this.englishTranslation;
    }

    //Method to return Kannada Value
    public String getKannadaTranslation() {
        return this.kannadaTranslation;
    }

    //method to get the image id
    public int getImgId() {
        return this.imgId;
    }

    /**
     * determine weather image is there or not
     * @return
     */
    public boolean hasImage(){
        return imgId!=noImage;
    }

    /**
     * this method is to return the audio file id
     * @return Audio_id
     */
    public int getAudioId(){
        return this.audioId;
    }
}
