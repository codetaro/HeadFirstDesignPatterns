<jsp:useBean id="beatModel" scope="request" class="patterns.compound.dj.BeatModel"/>

<html>
<head>
    <title>DJ View</title>
</head>

<body>
<%--打印出当前的BPM--%>
<h1>DJ View</h1>
Beats per minutes =
<jsp:getProperty name="beatModel" property="BPM"/>
<br/>
<hr>
<br/>

<form method="get" action="/dj/servlet/DJViewServlet">
    BPM: <input type="text" name="bpm"
                value="<jsp:getProperty name="beatModel" property="BPM"/>">
    &nbsp;
    <%--视图控件部分--%>
    <input type="submit" name="set" value="set"><br/>
    <input type="submit" name="decrease" value="<<">
    <input type="submit" name="increase" value=">>"><br/>
    <input type="submit" name="on" value="on">
    <input type="submit" name="off" value="off"><br/>
</form>

</body>
</html>