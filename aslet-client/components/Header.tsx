import Link from "next/link";
import ASLET from "./ASLET";

export default function Header() {
    return (
        <>
            <header className="bg-gray-400 w-screen">
                <div className="max-w-5xl mx-auto flex justify-around">
                    <img src="/" alt="Лого" />
                    <nav className="flex flex-row space-x-2">
                        <Link href="/">Какво е <ASLET />?</Link>
                        <Link href="">Кои са създателите му?</Link>
                        <Link href="">Към <ASLET /></Link>
                    </nav>
                    <div>
                        <Link href="/auth/login">Влез</Link>
                    </div>
                </div>
            </header>
        </>
    )
}