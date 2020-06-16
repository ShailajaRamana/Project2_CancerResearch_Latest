package learning.datascience.shailu.project1.domain;

public enum Sex {
    MALE("Male"),
    FEMALE("Female");

    private String type;

    private Sex(String type){
        this.type = type;
    }

    public static Sex getSex(String sexType){
        if(sexType == null) return null;
        Sex sex = null;
        switch (sexType){
            case "Male" : sex = MALE;
                          break;
            case "Female" : sex = FEMALE;
                break;

        }

        return sex;
    }
}
