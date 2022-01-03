public class User implements Comparable <User> {
private int number_of_likes ;
private Text record ;

public User (int number_of_likes ,  Text record){
    this.number_of_likes = number_of_likes;
    this.record = record ;
}

public int getNumberOfLikes() {
    return number_of_likes;
}
public Text getRecord() {
    return record;
}
@Override 
public int compareTo (User user){
    return this.number_of_likes - user.number_of_likes;
}
}