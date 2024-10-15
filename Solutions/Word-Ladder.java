// https://leetcode.com/problems/word-ladder

class WordLadderSolution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        for (String word : wordList){
            visited.add(word);
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int dist = 0; 

        while (! queue.isEmpty()){
            // Want to do a level by level traversal
            // Shortest path will be found at the shallowest level in which we detect endWord (if it exists)
            int size = queue.size(); 
            for (int i = 0; i < size; i++){
                char[] currWord = queue.remove().toCharArray(); 
                if (endWord.equals(String.valueOf(currWord))){
                    return dist + 1; 
                }
                for (int j = 0; j < currWord.length; j++){
                    char orignal = currWord[j];
                    for (char ch = 'a'; ch <= 'z'; ch++){
                        currWord[j] = ch; 
                        if (visited.contains(String.valueOf(currWord))){
                            queue.add(String.valueOf(currWord));
                            visited.remove(String.valueOf(currWord));
                        }
                    }
                    currWord[j] = orignal;
                }
            }
            dist += 1; 
        }
        return 0; 
    }
}