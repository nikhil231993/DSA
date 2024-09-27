package leetcode.graph;

import java.util.*;

public class G50LC721AccountsMerge {

    public static void main(String[] args) {

        List<List<String>> accounts = new ArrayList<List<String>>();
        accounts.add(Arrays.asList("John","J1@m.co","J2@m.co","J3@m.co"));
        accounts.add(Arrays.asList("John","J4@m.co"));
        accounts.add(Arrays.asList("raj","r1@m.co","r2@m.co"));
        accounts.add(Arrays.asList("John","J1@m.co","J5@m.co"));
        accounts.add(Arrays.asList("raj","r2@m.co","r3@m.co"));
        accounts.add(Arrays.asList("Mary","M1@m.co"));

        System.out.println(accountsMerge(accounts));
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {

        int noOfNames=accounts.size();
        //Create a map with key and value where key is the email id and value is the list(0);
        Map<String,Integer> emailToNode=new HashMap<>();

        //Also a disjoint set is needed;
        DisjointSetBySize ds=new DisjointSetBySize(noOfNames);

        //Parse and put in map and create union if the string already exist in map

        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email=accounts.get(i).get(j);
               if(!emailToNode.containsKey(email)){
                   emailToNode.put(email,i);
               }else{
                   ds.unionBySize(i,emailToNode.get(email));
               }
            }
        }

        //Now merge all the email having same value to same list
        List<List<String>> mergeList=new ArrayList<>();
        for(int i=0;i<accounts.size();i++){
            mergeList.add(new ArrayList<>());
        }

        for(Map.Entry<String, Integer> m:emailToNode.entrySet()){

            String email=m.getKey();
            Integer node=ds.findParent( m.getValue());
            mergeList.get(node).add(email);
        }

        //Now put the node value and create a new list
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<accounts.size();i++){
            //check if there are elements in list
            if(mergeList.get(i).size()==0) continue;
            //If present then sort it
            Collections.sort(mergeList.get(i));
            System.out.println("+++++++");
            System.out.println(mergeList.get(i));
            System.out.println("+++++++");
            //Create new ArrayList to add value;
            List<String> tempList=new ArrayList<>();
            tempList.add(accounts.get(i).get(0));

//          for(int j=0;j<mergeList.get(i).size();j++){
            tempList.addAll(mergeList.get(i));
//          }
            ans.add(tempList);
        }

        return ans;

        //Time Complexity: O(N+E) + O(E*4ɑ) + O(N*(ElogE + E)) where N = no. of indices or nodes
        // and E = no. of emails.
        // The first term is for visiting all the emails. The second term is for merging the accounts.
        // And the third term is for sorting the emails and storing them in the answer array.
        //Space Complexity: O(N)+ O(N) +O(2N) ~ O(N) where N = no. of nodes/indices.
        // The first and second space is for the ‘mergedMail’ and the ‘ans’ array.
        // The last term is for the parent and size array used inside the Disjoint set data structure.

    }
}
