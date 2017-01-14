<%@ page import="bean.User" %>
    <div id="content" ng-controller="myCtrl" data-ng-init="init()">
        <div class="mycontainer">
            <div class="cont1"></div>
            <div class="cont2">
                <%
                    	User u = (User)session.getAttribute("utilisateur");
                    
                    
                    
                    %>
                    <div class="post">
                        <span><% out.print("Hello " + u.getFirstName()); %></span>
                            <form name="post" method="post" ng-submit="runBoth()" style="margin-top:10px">
                                <input type="hidden" value="<%out.print (u.getId()) ;%>" name="id" id="idUser">
                                <textarea required name="post" type="text" required class="form-control" rows="5" ng-model="poste" ng-trim="false" maxlength="1500"> </textarea>
                                <input type="submit" id="insert" ng-disabled="post.$invalid" class="btn btn-primary pull-right" value="Post">
                                <button class="btn btn-default length pull-right">{{1500 - poste.length}} </button>
                            </form>
                    </div>
                    <div class="op" id="op"></div>
                    <div class="posts" id="divID">
                        <div class="postt" ng-repeat="x in names | orderObjectBy:'id'"> {{ x.post }}
                            <hr style="border-color:#b7b7b7"> <span class="pull-right">{{ x.datePost }}</span> Posted by {{x.firstname}} {{x.lastname}} </div>
                    </div>
                    <div class="cont3"> </div>
            </div>
        </div>
        <script src="inc/js/front.js"></script>