

class Solution {
    static ArrayList<ArrayList<Integer>> uniqueCombinations(int[] arr, int target) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        backtrack(0, arr, target, new ArrayList<>(), ans);
        return ans;
    }

    static void backtrack(int idx, int[] arr, int target, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            // skip duplicates
            if (i > idx && arr[i] == arr[i - 1]) continue;

            if (arr[i] > target) break;

            curr.add(arr[i]);
            backtrack(i + 1, arr, target - arr[i], curr, ans); // i+1, not idx+1
            curr.remove(curr.size() - 1);
        }
    }

}
