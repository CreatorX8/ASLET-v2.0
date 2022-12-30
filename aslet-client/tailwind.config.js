/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./pages/**/*.{js,ts,jsx,tsx}",
    "./components/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        'ASLETThemeColor': '#4169e1',
        'secondary': '#1F4591',
        'lightColor': '#EBEBEB',
        'darkColor': '#292929',
        'highlightLightColor': '#68A4F1',
        'highlightDarkColor': '#061E47',
        'okColor': '#67CF23',
        'warning': '#FA9B16',
        'errorColor': '#E52233'
      }
    },
  },
  plugins: [],
}
