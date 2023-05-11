# Weather API

This API is responsible for processing weather data from the files directory, and saving it in two different cassandra clusters/keyspaces/tables. The ideia here is to manage multiple connections to multiple cassandra repositories at the same time, with the same data model. These skills/practices can be applied in database migration projects, where you're migrating from a database to another. The base dataset used can be found [here](https://www.kaggle.com/muthuj7/weather-dataset).

This API is also responsible for processing weather data from the [OpenWeatherMap](https://openweathermap.org/) API and returning it in a more readable format.

This repository is also used to hone my skills in logging, observability, code architecture, unit testing, integration testing, and CI/CD.