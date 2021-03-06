import subprocess


def start(args, logfile, errfile):
    subprocess.Popen(
        "$PY3_GUNICORN --pid=gunicorn.pid hello.wsgi:application -c gunicorn_conf.py --env DJANGO_DB=mysql",
        cwd="django", shell=True, stderr=errfile, stdout=logfile)
    return 0


def stop(logfile, errfile):
    subprocess.call(
        "kill `cat gunicorn.pid`",
        cwd="django", shell=True, stderr=errfile, stdout=logfile)
    return 0
