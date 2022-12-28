import Link from "next/link";
import Header from "../../components/Header";
import { environment } from "../../env/client/eviroment.dev";

export default function LoginPage() {

    const handleLoginFormSubmit = (event: any) => {
        event.preventDefault();

        //TODO: add email and username
        const registerData = {
            name: event.target.name.value,
            password: event.target.password.value,
            // province: event.target.province.value,
            // cityVillage: event.target.cityVillage.value,
            // schoolName: event.target.schoolName.value
            email: "tempemail@example.com",
            username: "tempusername"
        }
        console.log(registerData)

        const endpoint = `${environment.SERVER_API}/auth/register`;

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