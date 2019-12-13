/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.EducationChildren;

import java.util.ArrayList;

/**
 *
 * @author nitis
 */
public class EducationChildrenDirectory {
    private ArrayList<EducationChildren> educationChildrenList;
    
    public EducationChildrenDirectory(){
        this.educationChildrenList = new ArrayList<>();
    }

    public ArrayList<EducationChildren> getEducationChildrenList() {
        return educationChildrenList;
    }

    public void setEducationChildrenList(ArrayList<EducationChildren> educationChildrenList) {
        this.educationChildrenList = educationChildrenList;
    }
    
    public EducationChildren createEducationChildren(String name, int age){
        EducationChildren child = new EducationChildren();
        child.setName(name);
        child.setAge(age);
        child.setStatus(false);
        educationChildrenList.add(child);
        return child;
    }
    
    public void removeEducationChildren(EducationChildren child){
        educationChildrenList.remove(child);
    }
}
