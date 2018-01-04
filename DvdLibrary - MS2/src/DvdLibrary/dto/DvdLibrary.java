/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DvdLibrary.dto;

/**
 *
 * @author laptop
 */
public class DvdLibrary {

    private String title;
    private String mpaaRating;
    private String releaseDate;
    private String directorsName;
    private String studio;
    private String userNote;
    
    

    /*
    Title
Release date
MPAA rating
Director's name
Studio
User rating or note (allows user to enter additional information, e.g., "Good family movie")
     */
    
    
    //I'll add a constructor here and base it off the title
    
    public DvdLibrary (String title){
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

//    public void setTitle(String title) {
//        this.title = title;
//    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }
}
