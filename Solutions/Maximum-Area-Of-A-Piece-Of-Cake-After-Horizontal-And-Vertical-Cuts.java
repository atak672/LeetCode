// https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts

class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCutsSolution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long height = 0; 
        int prev = 0; 
        for (int num : horizontalCuts){
            int gap = num - prev; 
            if (gap > height){
                height = gap;
            }
            prev = num; 
        }
        if (h - prev > height){
            height = h - prev;
        }


        long width = 0; 
        prev = 0; 
        for (int num : verticalCuts){
            int gap = num - prev; 
            if (gap > width){
                width = gap;
            }
            prev = num;
        }

        if (w - prev > width){
            width = w - prev;
        }

        return (int) ((width * height) %  (1_000_000_007));
        
    }
}