import asyncio
import pyowm

API_KEY = '43e7e417aa8317ede5595be556bf47b5'


async def print_temperature(obs, city):
    weather = obs.get_weather()
    temperature = weather.get_temperature('celsius')['temp']
    while True:
        print(f'The temperature in  {city} is: {temperature} celsius')
        await asyncio.sleep(2)


async def print_wind(obs, city):
    weather = obs.get_weather()
    wind = weather.get_wind()['speed']
    while True:
        print(f'The speed of wind in {city} is: {wind} ')
        await asyncio.sleep(4)


async def main():
    owm = pyowm.OWM(API_KEY)
    print('Enter the city you want to look weather for')
    first_city = input()
    print('Enter the city you want to look weather for')
    second_city = input()
    first_observation = owm.weather_at_place(first_city)
    second_observation = owm.weather_at_place(second_city)
    task1 = asyncio.create_task(print_temperature(first_observation, first_city))
    task2 = asyncio.create_task(print_wind(first_observation, first_city))
    task3 = asyncio.create_task(print_temperature(second_observation, second_city))
    task4 = asyncio.create_task(print_wind(second_observation, second_city))
    await asyncio.gather(task1, task2, task3, task4)


if __name__ == '__main__':
    asyncio.run(main())
