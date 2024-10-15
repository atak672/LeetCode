// https://leetcode.com/problems/subdomain-visit-count

class SubdomainVisitCountSolution {
    public List<String> subdomainVisits(String[] cpdomains) {

        // One pass with hashmap -- for each . domain, starting from the right and moving to the left, incrememnt 

        HashMap<String, Integer> counts = new HashMap<>();

        for (String str : cpdomains){
            String[] temp = str.split(" ");
            int numVisited = Integer.valueOf(temp[0]);
            StringBuilder domain = new StringBuilder(temp[1]);
            while (true) {
                int i = domain.indexOf(".");
                counts.putIfAbsent(domain.toString(), 0);
                counts.put(domain.toString(), counts.get(domain.toString()) + numVisited);
                domain.delete(0, i+1);
                if (i == -1){
                    break;
                }
            }
        }

        List<String> ret = new ArrayList<>();
        for (String domain : counts.keySet()){
            String ans = counts.get(domain) + " " + domain;
            ret.add(ans);
        }
        return ret; 
    }
}