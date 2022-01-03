# Adding Custom HTML

By default, Nginx looks in the _/usr/share/nginx/html_ directory inside of the container for files to serve. We need to get our html files into this directory. A fairly simple way to do this is use a mounted volume. With mounted volumes, we are able to link a directory on our local machine and map that directory into our running container.