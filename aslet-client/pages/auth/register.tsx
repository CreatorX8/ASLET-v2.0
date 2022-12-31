import Link from "next/link";
import Header from "../../components/Header";
import { IRegisterData } from "../../src/models/register.model";

export default function LoginPage(props: {server: string}) {

    const handleLoginFormSubmit = (event: any) => {
        event.preventDefault();

        //TODO: add username
        const registerData: IRegisterData = {
            name: event.target.name.value,
            email: event.target.email.value,
            password: event.target.password.value,
            province: event.target.province.value,
            cityVillage: event.target.cityVillage.value,
            schoolName: event.target.schoolName.value,

            //username: "tempusername"
        }

        if (checkRegisterData(registerData)) {
            registerRequest(registerData);
            return;
        }

        //Change UI

    }

    const checkRegisterData = (registerData: IRegisterData): boolean => {

        //TODO: Email checker
        //TODO: Password Checker

        return true;
    }

    const registerRequest = (registerData: IRegisterData): true | Error => {

        const endpoint = `${props.server}/auth/login`;

        const options = {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(registerData)
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

    //TODO: Make province a combobox

    return (
        <>
            <Header />
            <main className="w-screen h-fit flex justify-center">
                <div className="max-w-3xl p-6">
                    <form onSubmit={handleLoginFormSubmit} className="flex flex-col space-y-5">
                        <input className="border-ASLETThemeColor border-2 rounded-lg p-1"
                            type="text" placeholder="Име" id="nameInput" name="name" autoComplete="name" required />
                        <input className="border-ASLETThemeColor border-2 rounded-lg p-1"
                            type="email" placeholder="E-mail" id="emailInput" name="email" autoComplete="email" required />
                        <input className="border-ASLETThemeColor border-2 rounded-lg p-1"
                            type="password" placeholder="Парола" id="passwordInput" name="password" autoComplete="password" required />
                        <hr />
                        <input className="border-ASLETThemeColor border-2 rounded-lg p-1"
                            type="text" placeholder="Област" id="provinceInput" name="province" required />
                        <input className="border-ASLETThemeColor border-2 rounded-lg p-1"
                            type="text" placeholder="Град/Село" id="cityVillageInput" name="cityVillage" required />
                        <input className="border-ASLETThemeColor border-2 rounded-lg p-1"
                            type="text" placeholder="Име на училището" id="schoolNameInput" name="schoolName" required />

                        <input className="bg-ASLETThemeColor rounded-lg p-1"
                            type="submit" value="Регистрирай се" />
                    </form>
                    <p>Вече имаш профил? <Link href="/auth/login">Влез</Link></p>
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