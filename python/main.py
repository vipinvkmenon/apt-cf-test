import os
from flask import Flask
import subprocess

app = Flask(__name__)

@app.route('/')
def hello():
	return 'Hello World!!'

@app.route('/DebianApplication')
def runDebApp():
    p = subprocess.Popen('ascii', shell=True, stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
    outputString = ""
    for line in p.stdout.readlines():
     outputString += line+"</br>"
    return outputString
    retval = p.wait()


port = os.getenv('PORT', '5000')
if __name__ == "__main__":
	app.run(host='0.0.0.0', port=int(port))