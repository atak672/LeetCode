// https://leetcode.com/problems/alien-dictionary

class AlienDictionarySolution {
    public String alienOrder(String[] words) {

        // It is giving topological order
        // I.e. find order s.t. a word comes before another in each case 
        // That order is the valid order -- if it doesnt exist return "" 

        // If a word comes before another word, add an outgoing edge --> from the word into the one it goes into 


        Map<String, Set<String>> graph = new HashMap<>();
        buildGraph(words, graph);

        // for(String let : graph.keySet()){
        //     System.out.println(let);
        //     System.out.println(graph.get(let));
        // }


        Stack<String> stack = new Stack<>(); 
        Set<String> visited = new HashSet<>();
        Set<String> recursionStack = new HashSet<>();
        for (String letter : graph.keySet()){
            if (! visited.contains(letter)){
                if (dfs(letter, graph, visited, recursionStack, stack)){
                    return "";
                }
            }
        }

        StringBuilder ret = new StringBuilder();

        while (! stack.isEmpty()){
            ret.append(stack.pop());
        }

        return ret.toString(); 
    }

    // The words themselves are in lexicographical order 
    // How can we formula all the relationships in O(<<= N^3)
    public boolean dfs(String currNode, Map<String, Set<String>> graph, Set<String> visited, Set<String> recursionStack, Stack<String> stack){

        visited.add(currNode);
        recursionStack.add(currNode);

        for (String neighbor : graph.get(currNode)){
            if (recursionStack.contains(neighbor)){
                return true; 
            }

            if (! visited.contains(neighbor)){
                if (dfs(neighbor, graph, visited, recursionStack, stack)){
                    return true;
                }
            }
        }

        recursionStack.remove(currNode);
        stack.push(currNode);

        // No cycle found yet
        return false; 

    }



    public void buildGraph(String[] words, Map<String, Set<String>> graph){
        
       // Need to figure out how to build the graph and orient it s.t. we have outgoing and incoming edges refelcting a comes before b (a -> b)

       // List is provided in sorted order 
       // How does sorting work? Compare on a position by position basis s
       // Can do pairwise comparisons for each letter. If currnet position is equal, go next, once not equal add outgoing to incoming from one that occurs
       // Earlier to one that occurs later

        for (String word : words){
            for (char ch : word.toCharArray()){
                graph.putIfAbsent(String.valueOf(ch), new HashSet<>());
            }
        }

        for (int j = 0; j < words.length - 1; j++){
            String wordOne = words[j];
            String wordTwo = words[j + 1];

            for (int i = 0; i < wordOne.length(); i++){
                if (i >= wordTwo.length()){
                    graph.get(wordOne.substring(i, i + 1)).add(wordOne.substring(i, i + 1));
                }
                else if (wordOne.charAt(i) != wordTwo.charAt(i)){
                    graph.get(wordOne.substring(i, i + 1)).add(wordTwo.substring(i, i +1));
                    break;
                }
            }
        }

       
       return;       
    }
}