/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author nitis
 */
public class RehabilationEnterprise extends Enterprise{
    public RehabilationEnterprise(String name) {
        super(name, EnterpriseType.Rehabilation);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
       return null;
    }
}
