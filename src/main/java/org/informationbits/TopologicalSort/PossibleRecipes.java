package org.informationbits.TopologicalSort;

import java.util.*;

/**
 * https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
 */
public class PossibleRecipes {
    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> supplieSet = new HashSet<String>();
        Collections.addAll(supplieSet, supplies);

        Map<String, Node> graph = new HashMap<String, Node>();
        for (int i = 0; i < recipes.length; i++) {
            graph.put(recipes[i], new Node(recipes[i]));
        }

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            if (!graph.containsKey(recipe)) continue;
            for (String ing : ingredients.get(i)) {
                if (!supplieSet.contains(ing) && !graph.containsKey(ing)) {
                    removeRecipe(graph, recipe);
                    break;
                }
                if (graph.containsKey(ing)) {
                    graph.get(recipe).fromRecipes.add(ing);
                    graph.get(ing).toRecipes.add(recipe);
                }
            }
        }

        Queue<String> qu = new LinkedList<String>();
        for (Map.Entry<String, Node> entry : graph.entrySet()) {
            String recipe = entry.getKey();
            Node recipeDetail = entry.getValue();
            if (recipeDetail.fromRecipes.size() == 0) qu.add(recipe);
            //Note - Importance of this line it is used to fix all the toRecipes Set (remove is only cleaning up toRecipe Set)
            recipeDetail.toRecipes.retainAll(graph.keySet());
        }

        ArrayList<String> possibleRecipe = new ArrayList<String>();
        while (!qu.isEmpty()) {
            String recipe = qu.remove();
            possibleRecipe.add(recipe);
            Node recipeDetail = graph.get(recipe);
            for (String toRecipe : recipeDetail.toRecipes) {
                graph.get(toRecipe).fromRecipes.remove(recipe);
                if (graph.get(toRecipe).fromRecipes.size() == 0) qu.add(toRecipe);
            }
        }
        return possibleRecipe;
    }

    //Note we need to recursively clean the toRecipes and fromRecipes. But fromRecipes is handled separately otherwise
    //we will get null pointer exception.
    private static void removeRecipe(Map<String, Node> graph, String recipe) {
        if (!graph.containsKey(recipe)) return;
        Node recipeToRemove = graph.remove(recipe);
        for (String r : recipeToRemove.toRecipes) {
            removeRecipe(graph, r);
        }
    }


    static class Node {
        String recipeName;
        //In case other recipes are need to make store their list.
        Set<String> fromRecipes;
        //In case other recipes needs me store their list.
        Set<String> toRecipes;
        boolean isPossible;

        Node(String name) {
            recipeName = name;
            fromRecipes = new HashSet<String>();
            toRecipes = new HashSet<String>();
            isPossible = true;
        }
    }
}
