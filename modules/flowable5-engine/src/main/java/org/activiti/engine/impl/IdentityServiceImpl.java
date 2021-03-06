/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.engine.impl;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.impl.identity.Authentication;
import org.flowable.engine.impl.util.CommandContextUtil;
import org.flowable.idm.api.Group;
import org.flowable.idm.api.GroupQuery;
import org.flowable.idm.api.IdmIdentityService;
import org.flowable.idm.api.NativeGroupQuery;
import org.flowable.idm.api.NativeUserQuery;
import org.flowable.idm.api.Picture;
import org.flowable.idm.api.User;
import org.flowable.idm.api.UserQuery;

/**
 * @author Tom Baeyens
 */
public class IdentityServiceImpl extends ServiceImpl implements IdentityService {

    public IdentityServiceImpl() {

    }

    public IdentityServiceImpl(ProcessEngineConfigurationImpl processEngineConfiguration) {
        super(processEngineConfiguration);
    }

    public Group newGroup(String groupId) {
        return getIdmIdentityService().newGroup(groupId);
    }

    public User newUser(String userId) {
        return getIdmIdentityService().newUser(userId);
    }

    public void saveGroup(Group group) {
        getIdmIdentityService().saveGroup(group);
    }

    public void saveUser(User user) {
        getIdmIdentityService().saveUser(user);
    }

    public void updateUserPassword(User user) {
        getIdmIdentityService().updateUserPassword(user);
    }

    public UserQuery createUserQuery() {
        return getIdmIdentityService().createUserQuery();
    }

    @Override
    public NativeUserQuery createNativeUserQuery() {
        return getIdmIdentityService().createNativeUserQuery();
    }

    public GroupQuery createGroupQuery() {
        return getIdmIdentityService().createGroupQuery();
    }

    @Override
    public NativeGroupQuery createNativeGroupQuery() {
        return getIdmIdentityService().createNativeGroupQuery();
    }

    public void createMembership(String userId, String groupId) {
        getIdmIdentityService().createMembership(userId, groupId);
    }

    public void deleteGroup(String groupId) {
        getIdmIdentityService().deleteGroup(groupId);
    }

    public void deleteMembership(String userId, String groupId) {
        getIdmIdentityService().deleteMembership(userId, groupId);
    }

    public boolean checkPassword(String userId, String password) {
        return getIdmIdentityService().checkPassword(userId, password);
    }

    public void deleteUser(String userId) {
        getIdmIdentityService().deleteUser(userId);
    }

    public void setUserPicture(String userId, Picture picture) {
        getIdmIdentityService().setUserPicture(userId, picture);
    }

    public Picture getUserPicture(String userId) {
        return getIdmIdentityService().getUserPicture(userId);
    }

    public void setAuthenticatedUserId(String authenticatedUserId) {
        Authentication.setAuthenticatedUserId(authenticatedUserId);
    }

    public String getUserInfo(String userId, String key) {
        return getIdmIdentityService().getUserInfo(userId, key);
    }

    public List<String> getUserInfoKeys(String userId) {
        return getIdmIdentityService().getUserInfoKeys(userId);
    }

    public void setUserInfo(String userId, String key, String value) {
        getIdmIdentityService().setUserInfo(userId, key, value);
    }

    public void deleteUserInfo(String userId, String key) {
        getIdmIdentityService().deleteUserInfo(userId, key);
    }
    
    protected IdmIdentityService getIdmIdentityService() {
        return CommandContextUtil.getIdmIdentityService();
    }
}
