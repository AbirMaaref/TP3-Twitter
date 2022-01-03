package tn.isima.tp3;
 import org.apache.hadoop.io.DoubleWritable;
 import org.apache.hadoop.io.Text;
 import org.apache.hadoop.mapreduce.Mapper;
 import java.io.IOException;
 import java.util.StringTokenizer;

 public class ReduceTweet extends Reducer<NullWritable, Text, NullWritable, Text> {

    private PriorityQueue<User> numberOfLikesPriorityQueue = new PriorityQueue<>();

    @Override
    public void reduce(NullWritable key , Iterable<Text> values , Context context) 
    throws IOException, InterruptedException {
        String line = value.toString();
        String[] data = line.split('\t');
        String number_of_likes = Integer.parseInt(data[1]);
        User user = numberOfLikesPriorityQueue.peek();

        if (numberOfLikesPriorityQueue.size()<=3 || number_of_likes > user.getNumberOfLikes()) {
            numberOfLikesPriorityQueue.add(new User (number_of_likes , new Text(value)));
                if (numberOfLikesPriorityQueue.size()>3) {
                    numberOfLikesPriorityQueue.remove(user);
                }
            }
    }
}