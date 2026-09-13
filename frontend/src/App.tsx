import ApplicationCard from "./ApplicationCard.tsx";
import {useState} from "react";

type Application = {
    id: number
    company: string
    position: string
    status: string
}


function App() {
    const [applications, setApplications] = useState<Application[]>([
        {
            id: 1,
            company: 'adesso',
            position: 'Working Student Backend',
            status: 'APPLIED',
        },
        {
            id: 2,
            company: 'Materna',
            position: 'Working Student Software Development',
            status: 'INTERVIEW',
        },
    ])

    const [company, setCompany] = useState('')
    const [position, setPosition] = useState('')
    const [status, setStatus] = useState('DRAFT')

    const [showView, setShowView] = useState<"form" | "list">("list")

    const [editingId, setEditingId] = useState<number | null>(null)


    function handleDelete(id: number) {
        setApplications(
            applications.filter((application) => application.id !== id),
        )
    }

    function handleEdit(id: number) {
        const application = applications.find((application) => application.id === id)
        if (application) {
            setCompany(application.company)
            setPosition(application.position)
            setStatus(application.status)
            setEditingId(id)
            setShowView("form")
        }
    }

    function handleSubmit(event: React.FormEvent<HTMLFormElement>) {
        event.preventDefault()
        if (editingId === null) {
            const newApplication: Application = {
                id: Date.now(),
                company: company,
                position: position,
                status: status,
            }
            setApplications([...applications, newApplication])
        } else {
            setApplications(
                applications.map((application) => application.id === editingId ?
                    {
                        id: application.id,
                        company: company,
                        position: position,
                        status: status,
                    }
                    : application
                )
            )
        }
        setCompany('')
        setPosition('')
        setStatus('DRAFT')
        setShowView("list")
        setEditingId(null)
    }

    return (
        <main>
            <h1>Application Tracker</h1>
            {showView === "form" && (<form onSubmit={handleSubmit}>
                <label htmlFor="company">company</label>
                <input
                    id="company"
                    value={company}
                    onChange={(event) => setCompany(event.target.value)}
                />
                <label htmlFor="position">position</label>
                <input
                    id="position"
                    value={position}
                    onChange={(event) => setPosition(event.target.value)}
                />
                <label htmlFor="status">status</label>
                <select
                    id="status"
                    value={status}
                    onChange={(event) => setStatus(event.target.value)}
                >
                    <option value="DRAFT">Draft</option>
                    <option value="APPLIED">Applied</option>
                    <option value="INTERVIEW">Interview</option>
                    <option value="REJECTED">Rejected</option>
                    <option value="OFFER">Offer</option>
                </select>
                <button type="submit">Add Application</button>
            </form>)}
            {showView === "list" && (
                <>
                    <button onClick={() => setShowView("form")}>Add Application</button>
                    <section>
                        {applications.map((application) => (
                            <ApplicationCard
                                key={application.id}
                                id={application.id}
                                company={application.company}
                                position={application.position}
                                status={application.status}
                                onDelete={handleDelete}
                                onEdit={handleEdit}
                            />
                        ))}
                    </section>
                </>)}
        </main>
    )
}

export default App