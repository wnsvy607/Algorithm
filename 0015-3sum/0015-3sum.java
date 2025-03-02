class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;

        Map<Integer, Integer> map = new TreeMap<>();
        Set<String> comb = new HashSet<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(var eni : map.entrySet()) {
            int ik = eni.getKey();
            int iv = eni.getValue();
            for(var enj : map.entrySet()) {
                int jk = enj.getKey();
                int jv = enj.getValue();

                if(ik > jk) continue;

                if(ik == jk && iv < 2) continue;
                int target = -(ik + jk);

                if(!map.containsKey(target)) continue;
            
                
                if(ik == jk && jk == target && iv < 3) continue;
                if(ik == target && iv < 2) continue;
                if(jk == target && jv < 2) continue;

                List<Integer> list = new ArrayList<>();
                list.add(ik); list.add(jk); list.add(target); list.sort(Integer::compare);
                
                String cKey = list.get(0) + "," + list.get(1);

                if(comb.contains(cKey)) continue;

                comb.add(cKey);
                result.add(list);
            }
        }


        return result;
    }
}