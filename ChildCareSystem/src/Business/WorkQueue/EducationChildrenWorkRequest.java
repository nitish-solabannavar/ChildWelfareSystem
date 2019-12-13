/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.EducationChildren.EducationChildren;

/**
 *
 * @author nitis
 */
public class EducationChildrenWorkRequest extends WorkRequest{
    private EducationChildren child;
    
    public EducationChildrenWorkRequest(){
        super(WorkRequest.WorkRequestType.EducationChildren.getValue());
    }

    public EducationChildren getChild() {
        return child;
    }

    public void setChild(EducationChildren child) {
        this.child = child;
    }
    
    @Override
    public String toString(){
        return child.getName();
    }
}
