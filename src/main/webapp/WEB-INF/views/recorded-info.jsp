<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head> Local Time Info page </head>
<body>
<h3>"Information written to our resource"</h3>
<h4>Today is :</h4>
<div id="current_date_time_block"></div>
<script type="text/javascript">
    function zero_first_format(value)
    {
        if (value < 10)
        {
            value='0'+value;
        }
        return value;
    }
    function date_time()
    {
        let current_datetime = new Date();
        let day = zero_first_format(current_datetime.getDate());
        let month = zero_first_format(current_datetime.getMonth()+1);
        let year = current_datetime.getFullYear();
        let hours = zero_first_format(current_datetime.getHours());
        let minutes = zero_first_format(current_datetime.getMinutes());
        let seconds = zero_first_format(current_datetime.getSeconds());

        return day+"."+month+"."+year+" "+hours+":"+minutes+":"+seconds;
    }
    document.getElementById('current_date_time_block').innerHTML = date_time();
</script>
</body>
</html>
