class Solution {
    public class Pair{
        String word;
        int step;
        Pair(String word, int step){
            this.word=word;
            this.step=step;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;
        Set<String> words=new HashSet<>(wordList);
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        words.remove(beginWord);
        while(!q.isEmpty()){
            Pair node=q.poll();
            String word=node.word;
            int step=node.step;
            if(word.equals(endWord)) return step;

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replacedArray=word.toCharArray();
                    replacedArray[i]=ch;
                    String replacedWord=new String(replacedArray);
                    if(words.contains(replacedWord)){
                        q.offer(new Pair(replacedWord, step+1));
                        words.remove(replacedWord);
                    }
                }
            }
        }
        return 0;
    }
}
