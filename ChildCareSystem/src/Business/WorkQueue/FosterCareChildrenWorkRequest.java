/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.FosterCareChildren.FosterCareChildren;

/**
 *
 * @author nitis
 */
public class FosterCareChildrenWorkRequest extends WorkRequest{
    private FosterCareChildren child;

    public FosterCareChildrenWorkRequest(){
        super(WorkRequest.WorkRequestType.FosterCareChildren.getValue());
    }

    public FosterCareChildren getChild() {
        return child;
    }

    public void setChild(FosterCareChildren child) {
        this.child = child;
    }
    
    @Override
    public String toString(){
        return child.getName();
    }
}
