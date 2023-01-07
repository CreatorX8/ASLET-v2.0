import Link from "next/link";
import { useRouter } from "next/router";

export default function Unauthorized401(){

    const router = useRouter();

    return(
        <>
            <button onClick={() => router.back()}>X</button>
            <h2>401</h2>
            <p>Хммм...<br/>Изглежда, че не сте си влезли в профила</p>
            <p>Можете да <Link href="/auth/login">влезете</Link> ако имате акаунт или да се <Link href="/auth/register">регистрирате</Link></p>
        </>
    )
}