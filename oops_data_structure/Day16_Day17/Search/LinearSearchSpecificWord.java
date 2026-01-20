public class LinearSearchProblem2{
    public static String findSentence(String[] list,String word){
        for(String sentence:list){
            if(sentence.contains(word))return sentence;
        }
        return "Not Found";
    }
    public static void main(String[] args){
        String[] sentences = {
                "Java is easy to learn",
                "Linear search is simple",
                "I like data structures",
                "Searching algorithms are important"
        };

        String word = "search";
        System.out.println(findSentence(sentences, word));
    }
}