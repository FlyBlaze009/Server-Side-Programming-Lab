import cgi

#parses input data from user like form submission
form = cgi.FieldStorage() 

#extract name field from the form 
name = form.getvalue('name') 

#print - sends as response to the browser

print('Content-type : text/html')
print(f""" <
     html> 
        <head> <title>  CGI Response </title></head>
        <body> Hello! {name} </body>
    </html>""")

