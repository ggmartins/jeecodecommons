<%@ page import="java.io.*,java.util.*" %>
<%@ page import="javax.servlet.*,java.text.*" %>
<div id="footer">
<!-- hacking with scriptlets  -->
<jsp:scriptlet>
  Date dNow = new Date();
  SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz ");
  out.print(ft.format(dNow));
  out.println("IP:"+request.getRemoteAddr());
</jsp:scriptlet>
</div>