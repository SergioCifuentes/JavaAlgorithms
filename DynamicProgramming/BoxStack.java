import java.util.HashMap;

public class BoxStack {
    public static class Box {
        private int height;
        private int width;
        private int depth;

        public Box(int height, int width, int depth) {
            this.height = height;
            this.width = width;
            this.depth = depth;
        }

        public int getHeight() {
            return height;
        }

        public boolean isLarger(Box box){
            return this.height>box.height && this.width>box.width && this.depth>box.depth;
        }
    }

    public static void main(String[] args) {
        Box[] boxes = new Box[10];
        boxes[0] = new Box(10, 5, 5);//3
        boxes[1] = new Box(10, 6, 7);//2
        boxes[2] = new Box(20, 5, 4);
        boxes[3] = new Box(8, 10, 10);
        boxes[4] = new Box(10, 10, 10);
        boxes[5] = new Box(10, 12, 12);
        boxes[6] = new Box(12, 4, 8);
        boxes[7] = new Box(13, 20, 21);
        boxes[8] = new Box(15, 16, 15);
        boxes[9] = new Box(17, 15, 13); //1
        System.out.println(getHighest(boxes, null, new HashMap<Box,Integer>()));

    }

    public static int getHighest(Box[] boxes, Box last, HashMap<Box, Integer> map) {
        if (last != null && map.containsKey(last))
            return map.get(last);
        int max = 0;
        if (boxes.length == 1) {
            return last.isLarger(boxes[0]) ? boxes[0].height : 0;
        }
        for (Box box : boxes) {

            if (last != null) {
                if (last.isLarger(box)) {
                    int height = getHighest(removeBox(boxes, box), box, map);
                    map.put(box, height);
                    max = Math.max(max, height);
                }
            } else {
                int height = getHighest(removeBox(boxes, box), box, map);
                map.put(box, height);
                max = Math.max(max, height);
            }
        }
        return max + (last==null?0:last.height);
    }

    public static Box[] removeBox(Box[] boxes, Box box) {
        Box[] list = new Box[boxes.length - 1];
        int i = 0;
        for (Box box2 : boxes) {
            if (!box2.equals(box)) {
                list[i] = box2;
                i++;
            }

        }
        return list;
    }

}
