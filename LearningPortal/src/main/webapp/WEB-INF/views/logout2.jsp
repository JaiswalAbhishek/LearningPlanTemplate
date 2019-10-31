<%session.invalidate();%>
<% HttpSession nsession = request.getSession(false);
if(nsession!=null) {
   String data=(String)session.getAttribute( "loginUser" );
   out.println(data);
}
else
  out.println("Session is not active");
%>