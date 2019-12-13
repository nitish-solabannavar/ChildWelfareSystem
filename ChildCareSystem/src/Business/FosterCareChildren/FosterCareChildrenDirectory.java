/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.FosterCareChildren;

import java.util.ArrayList;

/**
 *
 * @author nitis
 */
public class FosterCareChildrenDirectory {
    private ArrayList<FosterCareChildren> fosterCareChildrenList;
    
    public FosterCareChildrenDirectory(){
        this.fosterCareChildrenList = new ArrayList<>();
    }

    public ArrayList<FosterCareChildren> getFosterCareChildrenList() {
        return fosterCareChildrenList;
    }

    public void setFosterCareChildrenList(ArrayList<FosterCareChildren> fosterCareChildrenList) {
        this.fosterCareChildrenList = fosterCareChildrenList;
    }
    
    public FosterCareChildren createFosterCareChildren(String name, int age){
        FosterCareChildren child = new FosterCareChildren();
        child.setName(name);
        child.setAge(age);
        child.setStatus(false);
        fosterCareChildrenList.add(child);
        return child;
    }
    
    public void removeFosterCareChildren(FosterCareChildren child){
        fosterCareChildrenList.remove(child);
    }
}
