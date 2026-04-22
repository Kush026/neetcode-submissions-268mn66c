class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List[] graph = new List[numCourses];

        for(int[] pair: prerequisites) {

            int s = pair[0];
            int d = pair[1];

            if(graph[s] == null) {
                graph[s] = new ArrayList<Integer>();
            }

            graph[s].add(d);
        }

        for(int n = 0; n < numCourses; n++) {

            if(isCycle(graph, new HashSet<Integer>(), n)) {
                return false;
            }

        }

        return true;
    }

    private boolean isCycle(List[] graph, Set<Integer> visited, int cur) {

        if(visited.contains(cur)) {
            return true;
        }

        visited.add(cur);

        ArrayList<Integer> children = (ArrayList<Integer>) graph[cur];

        if(children != null) {
            for(int n: children) {
                if(isCycle(graph, visited, n)) {
                    return true;
                }
            }
        }

        visited.remove(cur);
        return false;
    }
}
