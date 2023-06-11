package in.fivedegree.netclanclone.Fragments;

public class model {
    String imageUrl, Name, location, designation, range, pf_completion, bio, bio2; //coffee|business... skipped

    public model(String imageUrl, String name, String location, String designation, String range, String pf_completion, String bio, String bio2) {
        this.imageUrl = imageUrl;
        Name = name;
        this.location = location;
        this.designation = designation;
        this.range = range;
        this.pf_completion = pf_completion;
        this.bio = bio;
        this.bio2 =  bio2;

    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getPf_completion() {
        return pf_completion;
    }

    public void setPf_completion(String pf_completion) {
        this.pf_completion = pf_completion;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBio2() {
        return bio2;
    }

    public void setBio2(String bio2) {
        this.bio2 = bio2;
    }
}
