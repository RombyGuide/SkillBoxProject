package main;

import response.Case;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {
    private static HashMap<Integer ,Case> cases = new HashMap<>();
    private static int currentId = 1;

    public static synchronized List<Case> getAllCase() {
        ArrayList<Case> caseArrayList = new ArrayList<>();
        caseArrayList.addAll(cases.values());
        return caseArrayList;
    }

    public static synchronized int addCase(Case task) {
        int id = currentId++;
        task.setId(id);
        cases.put(id, task);
        return id;
    }

    public static synchronized Case getCase(int caseId) {
        if (cases.containsKey(caseId)) {
            return cases.get(caseId);
        }
        return null;
    }

    public static synchronized void updateCase(int caseId, Case updatedCase) {
        cases.replace(caseId, updatedCase);
    }

    public static synchronized void deleteCases() {
        cases.clear();
    }

    public static synchronized void deleteCase(int caseId) {
        if (cases.containsKey(caseId)) {
            cases.remove(caseId);
        }
    }
}
