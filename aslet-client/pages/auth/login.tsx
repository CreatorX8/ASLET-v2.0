import Link from "next/link";
import Header from "../../components/Header";
import { ILoginData } from "../../src/models/login.model";

export default function LoginPage(props: {server: string}): JSX.Element {

    const handleLoginFormSubmit = (event: any): void => {
        event.preventDefault();

        const loginData: ILoginData = {
            email: event.target.name.value,
            // name: event.target.name.value,
            password: event.target.password.value
        }

        if (checkLoginData(loginData)) {
            loginRequest(loginData);
            return;
        }

        //Change UI

    }

    const checkLoginData = (loginData: ILoginData): boolean => {

        //TODO: Email checker
        //TODO: Password Checker

        return true;
    }

    const loginRequest = (loginData: ILoginData): true | Error => {

        const endpoint = `${props.server}/auth/login`;

        const options = {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(loginData)
        }

        fetch(endpoint, options)
            .then((response: Response) => {
                response.json().then((result: any) => {
                    console.log(result);
                    //TODO: Next time on "Ivo is finaly doing something" with special guest: Redux
                })
            })
            .catch((error: any) => {
                console.error(error);
            })

        return true;
    }

    return (
        <>
            <Header />
            <main className="w-screen h-fit flex justify-center">
                <div className="max-w-3xl p-6">
                    <form onSubmit={handleLoginFormSubmit} className="flex flex-col space-y-5">
                        <input className="border-ASLETThemeColor border-2 rounded-lg p-1"
                            type="text" placeholder="Име" id="nameInput" name="name" autoComplete="name" required />
                        <input className="border-ASLETThemeColor border-2 rounded-lg p-1"
                            type="password" placeholder="Парола" id="passwordInput" name="password" autoComplete="password" required />
                        <input className="bg-ASLETThemeColor rounded-lg p-1"
                            type="submit" value="Вход" />
                    </form>
                    <p>Нямаш профил? <Link href="/auth/register">Регистрирай се</Link></p>
                </div>
            </main>
        </>
    )
}

export function getStaticProps(){
    return{
        props: {
            server: process.env.SERVER_URL
        }
    }
}